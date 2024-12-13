#!/usr/bin/env bash

set -e

# Validate the required environment variables
validate_env() {
  if [ "${!1}" = "" ]; then
      echo "Missing environment variable '$1'. Please provide all variables and try again"
      exit 1
  fi
}

validate_env "POSTGRES_HOST"
validate_env "POSTGRES_PORT"
validate_env "POSTGRES_USER"
validate_env "POSTGRES_PASSWORD"

# Function to create a user if it doesn't exist
create_user_if_not_exists() {
  local username="$1"
  local password="$2"
  echo "Checking if user $username exists..."

  USER_EXISTS=$(PGPASSWORD="$POSTGRES_PASSWORD" psql -h "$POSTGRES_HOST" -p "$POSTGRES_PORT" -U "$POSTGRES_USER" -tAc "SELECT 1 FROM pg_roles WHERE rolname='$username'")

  if [ "$USER_EXISTS" != "1" ]; then
    echo "User $username does not exist. Creating user..."
    PGPASSWORD="$POSTGRES_PASSWORD" psql -h "$POSTGRES_HOST" -p "$POSTGRES_PORT" -U "$POSTGRES_USER" -c "CREATE USER $username WITH PASSWORD '$password';"
  else
    echo "User $username exists. Updating password..."
    PGPASSWORD="$POSTGRES_PASSWORD" psql -h "$POSTGRES_HOST" -p "$POSTGRES_PORT" -U "$POSTGRES_USER" -c "ALTER USER $username WITH PASSWORD '$password';"
  fi
}

# Function to create a database if it doesn't exist
create_database_if_not_exists() {
  local db_name="$1"
  local username="$2"
  echo "Checking if database $db_name exists..."

  DB_EXISTS=$(PGPASSWORD="$POSTGRES_PASSWORD" psql -h "$POSTGRES_HOST" -p "$POSTGRES_PORT" -U "$POSTGRES_USER" -tAc "SELECT 1 FROM pg_database WHERE datname='$db_name'")

  if [ "$DB_EXISTS" != "1" ]; then
    echo "Database $db_name does not exist. Creating..."
    PGPASSWORD="$POSTGRES_PASSWORD" psql -h "$POSTGRES_HOST" -p "$POSTGRES_PORT" -U "$POSTGRES_USER" -c "CREATE DATABASE $db_name OWNER $username;"
  else
    echo "Database $db_name already exists."
  fi
}

# Function to process each service
process_services() {
  local services=("$@")

  for SERVICE in "${services[@]}"; do
    DB_NAME="${SERVICE}_db"
    DB_USER="${SERVICE}_user"
    DB_PASSWORD="${SERVICE}_password"
    echo "-----------------------------------------------------------------------------------"
    echo "Processing service: $SERVICE"

    # Create the user if it doesn't exist, or update the password
    create_user_if_not_exists "$DB_USER" "$DB_PASSWORD"

    # Create the database if it doesn't exist
    create_database_if_not_exists "$DB_NAME" "$DB_USER"

    echo "Finished processing service: $SERVICE"
  done
  echo "-----------------------------------------------------------------------------------"
}

# Define the services
SERVICES=("storefront_catalog" "storefront_checkout" "storefront_order" "storefront_seo" "storefront_customer")

# Call the function to process services
process_services "${SERVICES[@]}"
