---
marp: true
theme: semusings
paginate: true
header: '© Software Engineering Musings - <https://semusings.dev/> - subscribe us on :yt: 📺 at <https://youtube.com/@semusings>'
footer: ''
---

# AWS Certified Developer - Associate (DVA-C02)

---
## Exam Content Domains and Weightings

- **Content Domain 1: Development with AWS Services (32% of scored content)**
- **Content Domain 2: Security (26% of scored content)**
- **Content Domain 3: Deployment (24% of scored content)**
- **Content Domain 4: Troubleshooting and Optimization (18% of scored content)**

---

## Content Domain 1: Development with AWS Services

### Task 1: Develop code for applications hosted on AWS.
#### Knowledge of:
- Architectural patterns (e.g., event-driven, microservices, monolithic, choreography, orchestration, fanout)
- Idempotency
- Differences between stateful and stateless concepts
- Differences between tightly coupled and loosely coupled components
- Fault-tolerant design patterns (e.g., retries with exponential backoff and jitter, dead-letter queues)
- Differences between synchronous and asynchronous patterns

#### Skills in:
- Creating fault-tolerant and resilient applications in programming languages (e.g., Java, C#, Python, JavaScript, TypeScript, Go)
- Creating, extending, and maintaining APIs (e.g., response/request transformations, enforcing validation rules, overriding status codes)
- Writing and running unit tests in development environments (e.g., AWS Serverless Application Model [AWS SAM])
- Writing code to use messaging services
- Writing code that interacts with AWS services via APIs and SDKs
- Handling data streaming using AWS services

### Task 2: Develop code for AWS Lambda.
#### Knowledge of:
- Event source mapping
- Stateless applications
- Unit testing
- Event-driven architecture
- Scalability
- Access to private resources in VPCs from Lambda code

#### Skills in:
- Configuring Lambda functions (e.g., environment variables, memory, concurrency, timeout, runtime, handler, layers, extensions, triggers, destinations)
- Handling event lifecycle and errors using code (e.g., Lambda Destinations, dead-letter queues)
- Writing and running test code using AWS services and tools
- Integrating Lambda functions with AWS services
- Tuning Lambda functions for optimal performance

### Task 3: Use data stores in application development.
#### Knowledge of:
- Relational and non-relational databases
- CRUD operations
- High-cardinality partition keys for balanced partition access
- Cloud storage options (e.g., file, object, databases)
- Database consistency models (e.g., strongly consistent, eventually consistent)
- Differences between query and scan operations
- Amazon DynamoDB keys and indexing
- Caching strategies (e.g., write-through, read-through, lazy loading, TTL)
- Amazon S3 tiers and lifecycle management
- Differences between ephemeral and persistent data storage patterns

#### Skills in:
- Serializing and deserializing data for persistence in a data store
- Using, managing, and maintaining data stores
- Managing data lifecycles
- Using data caching services

---

## Content Domain 2: Security

### Task 1: Implement authentication and/or authorization for applications and AWS services.
#### Knowledge of:
- Identity federation (e.g., SAML, OIDC, Amazon Cognito)
- Bearer tokens (e.g., JWT, OAuth, AWS STS)
- Comparison of user pools and identity pools in Amazon Cognito
- Resource-based policies, service policies, and principal policies
- Role-based access control (RBAC)
- Application authorization using ACLs
- Principle of least privilege
- Differences between AWS managed policies and customer-managed policies
- Identity and access management

#### Skills in:
- Using an identity provider for federated access (e.g., Amazon Cognito, AWS IAM)
- Securing applications with bearer tokens
- Configuring programmatic access to AWS
- Making authenticated calls to AWS services
- Assuming an IAM role
- Defining permissions for principals

### Task 2: Implement encryption using AWS services.
#### Knowledge of:
- Encryption at rest and in transit
- Certificate management (e.g., AWS Private Certificate Authority)
- Key protection (e.g., key rotation)
- Differences between client-side and server-side encryption
- AWS managed vs. customer-managed AWS KMS keys

#### Skills in:
- Using encryption keys to encrypt or decrypt data
- Generating certificates and SSH keys for development
- Using encryption across account boundaries
- Enabling and disabling key rotation

### Task 3: Manage sensitive data in application code.
#### Knowledge of:
- Data classification (e.g., PII, PHI)
- Environment variables
- Secrets management (e.g., AWS Secrets Manager, AWS Systems Manager Parameter Store)
- Secure credential handling

#### Skills in:
- Encrypting environment variables containing sensitive data
- Using secret management services to secure sensitive data
- Sanitizing sensitive data

---

## Content Domain 3: Deployment

### Task 1: Prepare application artifacts to be deployed to AWS.
#### Knowledge of:
- Accessing application configuration data (e.g., AWS AppConfig, Secrets Manager, Parameter Store)
- Lambda deployment packaging, layers, and configuration options
- Git-based version control tools
- Container images

#### Skills in:
- Managing dependencies within the code package
- Organizing files and directory structure for deployment
- Using code repositories in deployment environments
- Applying resource requirements for applications (e.g., memory, cores)

### Task 2: Test applications in development environments.
#### Knowledge of:
- Features in AWS services for application deployment
- Integration testing using mock endpoints
- Lambda versions and aliases

#### Skills in:
- Testing deployed code with AWS tools
- Performing mock integration for APIs
- Testing applications with development endpoints
- Deploying stack updates to existing environments

### Task 3: Automate deployment testing.
#### Knowledge of:
- API Gateway stages
- Branches and actions in CI/CD workflows
- Automated software testing

#### Skills in:
- Creating test events (e.g., JSON payloads for Lambda, API Gateway)
- Deploying API resources to different environments
- Creating application environments for integration testing
- Implementing IaC templates

### Task 4: Deploy code using AWS CI/CD services.
#### Knowledge of:
- Git-based version control tools
- Manual and automated approvals in AWS CodePipeline
- CI/CD workflows using AWS services

#### Skills in:
- Updating IaC templates
- Managing application environments
- Deploying applications with deployment strategies
- Performing application rollbacks

---

## Content Domain 4: Troubleshooting and Optimization

### Task 1: Assist in a root cause analysis.
#### Knowledge of:
- Logging and monitoring systems
- Log query languages (e.g., CloudWatch Logs Insights)
- Data visualizations
- Code analysis tools
- Common HTTP error codes
- SDK-generated exceptions
- Service maps in AWS X-Ray

#### Skills in:
- Debugging code to identify defects
- Interpreting metrics, logs, and traces
- Querying logs for relevant data
- Reviewing application health via dashboards

### Task 2: Instrument code for observability.
#### Knowledge of:
- Distributed tracing
- Differences between logging, monitoring, and observability
- Structured logging
- Application metrics

#### Skills in:
- Implementing effective logging strategies
- Adding annotations for tracing services
- Implementing custom metrics and alerts

### Task 3: Optimize applications using AWS services and features.
#### Knowledge of:
- Caching
- Concurrency
- Messaging services (e.g., SQS, SNS)

#### Skills in:
- Profiling application performance
- Determining resource requirements
- Using subscription filter policies to optimize messaging
- Caching content based on request headers  

---

## Summary of Key Skills Across Domains

### Development:
- Build resilient applications with AWS SDKs.
- Write clean, testable, and fault-tolerant code.
- Design event-driven and loosely coupled architectures.

### Security:
- Implement robust IAM policies with least privilege principles.
- Use **AWS Secrets Manager** or **Systems Manager Parameter Store** for managing sensitive data.
- Encrypt data at rest and in transit with AWS KMS.

### Deployment:
- Automate CI/CD workflows using tools like **AWS CodePipeline**, **AWS SAM**, and **AWS CDK**.
- Use version control systems effectively for managing application artifacts.
- Implement canary or blue/green deployment strategies for minimal downtime.

### Troubleshooting:
- Analyze logs and traces to diagnose application issues.
- Use observability tools to track the health and performance of applications.
- Optimize resource usage and performance using caching and profiling services.