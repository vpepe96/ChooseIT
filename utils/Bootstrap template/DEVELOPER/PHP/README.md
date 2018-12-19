# SmartAdmin PHP
PHP 5.5, 7

## Install

### composer
Download and install [composer](https://getcomposer.org/download/). Go to a version e.g. `html/full` and run:
```
$ composer install
```

### notes
1. put your global configuration constants e.g. database in `lib/config.php`.
2. app classes and constants are declared in `init.php`.
3. UI configuration and other "web" related setup are in `init.web.php`.
4. `composer.json` uses `psr-4` standard for autoloading.