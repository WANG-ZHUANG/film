const {Nuxt, Builder} = require('nuxt');
const bodyParser = require('body-parser');
const session = require('cookie-session');
const app = require('express')();
const router = require('express').Router();