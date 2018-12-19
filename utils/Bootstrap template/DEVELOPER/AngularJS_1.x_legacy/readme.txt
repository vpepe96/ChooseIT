Please note this is a legacy version and it is no longer supported by us. Use at your own risk.

For anyone using this angular 1.x version 
It won't start using the standard ng serve you will need to do the following steps

Step 1: 
Import JQuery one time, across the project .
- Open .angular-cli.json
- Replace the existing scripts section with the following. 
"scripts": [
"../node_modules/jquery/dist/jquery.js",
], 

Step 2: 
Add declaration in the typings file
- Open src/typings.d.ts
- Declare jQuery declare var jQuery: any;
