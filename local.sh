#!/bin/bash
nvm install
nvm use
npm install
npx @marp-team/marp-cli@latest --theme ./etc/marp/themes/theme.css -c ./etc/marp/marp.config.js -s ./