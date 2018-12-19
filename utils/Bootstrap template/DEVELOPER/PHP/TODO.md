### General tasks

- [x] PHP 7 compatibility: 1hr
- [x] DataTables JS upgrade with SmartUI: 2.5hr
- [x] SmartUI Update: 3hr
- [x] Support for Composer package manager: 1hr
- [x] SmartUI update and a composer package: ~4hr
- [x] Other tasks (dev setup, etc.): 1hr

### 12/29/2017 bug fixes

- [-] Update the jquery in the pages to reflect jquery 3 (or the new jquery), this is the fallback one;
  > This is not part of the initial tasks. JS dependency updates are not coverered by PHP

- [-] smartui-accordion.php shows error on top of the page (Warning: file_get_contents(http://localhost/smartadmin/SmartAdmin_1_8/DEVELOPER/PHP/html/full/data/data.json): failed to open stream: An attempt was made to access a socket in a way forbidden by its access permissions. in C:\wamp\www\smartadmin\SmartAdmin_1_8\DEVELOPER\PHP\html\full\smartui-accordion.php on line 61)
  > This is a server setup on your end, can't do anything about it in code

- [x] The new dashboards are missing. Please see html version provided as demo
  > done

- [x] When HTML pages are opened, you need to add a open class to the UL block so it does not do a 'flip' animation, which can be a bit disturbing. (see how it shoud look like here: https://smartadmin-html.firebaseapp.com/), click any of the menu items and see how the menu stays expanded on page load by adding the class "active open"
  > fixed

- [x] datatables needs to use the new method for pdf generator, fullscreen, print, download csv etc, the old mechanism using swf files should be avoided. 
  > done

- [x] datatables.php is not working
  > fixed

- [x] login.php, register, forgotpassword, locked.php has unclosed html tag " --> "
  > fixed