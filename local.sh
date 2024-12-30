#!/bin/bash
nvm install
nvm use
npm install
PORT=5000 npx @marp-team/marp-cli@latest --theme-set ./etc/marp/themes -c ./etc/marp/marp.config.js -s ./