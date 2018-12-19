# SmartAdmin for ASP.NET Core 2.0

This is the home page of the SmartAdmin for ASP.NET Core 2.0 source code project and is intended for those wanting to integrate the highly adaptive SmartAdmin theme with ASP.NET Core 2.0.

SmartAdmin for ASP.NET Core is an update to the existing application framework for building modern applications, such as web apps and enabling responsive designs. SmartAdmin for ASP.NET Core apps can run on .NET Core or on the full .NET Framework. It was architected to provide an optimized development framework for apps that are deployed to the cloud or run on-premise. It consists of modular components with minimal overhead, so you retain flexibility while constructing your solutions. You can develop and run your ASP.NET Core apps cross-platform on Windows, Mac and Linux. [Learn more about ASP.NET Core](https://docs.microsoft.com/en-us/aspnet/core/).

## Getting Started

This section will help you get up-and-running with the SmartAdmin for ASP.NET Core solution for Visual Studio 2017.

**Note:** Support for Visual Studio 2015 is available as long as the targeting framework is set to 4.7. Installing and targeting .NET Framework 4.7 is up to user discretion, however this project focuses on targetting .NET Core 2.0 specifically and we higly recomment using the latest version of Visual Studio 2017.

### Folders and Projects

The SmartAdmin for ASP.NET Core solution is divided into several projects and solution folders. Each project has its own set of responsibilities and determines its tie-in with other projects. The structure as a whole delivers a smooth coding experience whether you have been coding in Visual Studio for a long time, or when you are in the process of mastering it.

Most of the code, and certainly that which is part of the public API, have been carefully documented with well written comments explaining what the code does, what its goal is, and how it should be used and which conditions would cause it to fail. This should also be reflected in the naming of entities and their properties to be as descriptive as possible to deliver an intuitive experience and invites you to adapt this as your coding automatism and in to writing your own!

#### Editions

This ASP.NET Core 2.0 project comes in 2 flavors, **Full** and **Seed**.

The main difference between them is that the Full version contains the setup for all template pages that you are familar with and the Seed version only contains the bare minimum to get started. This should enable you to focus on what you possibly want to add, rather than spending time in removing all of which you might not want to use (yet).

- The **Full** version of SmartAdmin for ASP.NET Core 2.0 can be found in: `./src/SmartAdmin.Web`
- The **Seed** version of SmartAdmin for ASP.NET Core 2.0 can be found in: `./src/SmartAdmin.Seed`

#### Folder Structure

The SmartAdmin for ASP.NET Core solution is categorized in the following folders:

| Folder | Purpose |
|---------------------------|---------------------------|
| **Web**         | Contains all the logic that is required in order to provide the markup with dynamic data, as well as routing related data in order to fire the requested action. e.g. Controllers, Routing and ViewModels. 
| **Web/Data**        | Contains the logic required to expose the data inside the SQL Server database using the EntityFramework Core library.
| **Web/Extensions**      | Contains cross-cutting logic and entities that are (re-)used throughout the application.
| **Web/Services**    | Contains all the services that provide functionality for the application, this relates to data-services which provides information from the data store as well as functional-services, such as calculations, charting and fundamental-services like identity and role management.
| **wwwroot**      | Contains all the assets that makes up for the SmartAdmin for ASP.NET Core website, no logic except that which is strictly required for presentation and validation. |


The SmartAdmin project uses the following solution folders:

| Folder | Purpose |
|---------------------------|---------------------------|
| **build**        | Contains the files used for versioning and building the application |
| **docs**        | Contains all the documentation files and assets |
| **samples**        | Contains all the sample projects that apply to the project |
| **src**        | Contains the source code of the web application for SmartAdmin for ASP.NET Core 2.0 |
| **tests**        | Contains the source code of the unit tests for SmartAdmin for ASP.NET Core 2.0 |

### ASP.NET Core 2.0 Components

These are the main ASP.NET Core components used by SmartAdmin for ASP.NET Core 2.0:

- [Configuration](https://github.com/aspnet/Configuration): Used to consume the application configuration files (`appSettings.json`)
- [EntityFramework Core](https://github.com/aspnet/EntityFrameworkCore): Used to manage and store data used by SmartAdmin.
- [Mvc](https://github.com/aspnet/Mvc): Used to setup and display the HTML pages that are produced by SmartAdmin.
- [Dependency Injection](https://github.com/aspnet/DependencyInjection): Used to setup and manage the life cycle of class instances that can be referenced throughout the application.

#### Authentication

Authentication of web site app users can leverage credentials from external authentication providers, such as Facebook, Twitter, Gmail and Microsoft account. Users can use their existing social media accounts to sign into the web site. For more information, see [Enabling authentication using external providers](https://docs.microsoft.com/en-us/aspnet/core/security/authentication/social/).

As application security and authentication are such a common feature of any modern web hosted website we have added ASP.NET Core Identity for both the **Full** as well as the **Seed** project.

#### Configuration

The SmartAdmin for ASP.NET Core 2.0 project relies on configuration settings at runtime, such as whether to use a local database, SQL Database or a Azure hosted SQL Database for data storage, whether to load seed data, default accounts information, and credentials for connecting to other services. These setting values can be stored in the project's `appSettings.json` file. 

However, doing so makes it vulnerable to accidentally expose secrets, so please be aware of who has access to this information. When you publish the project to, for example, Azure Web Apps or any other hosting provider, you will need to set these same values as app settings in your web app.

**Note:** currently the codebase includes values for a couple of 'secret' values in the configuration. As you might typically deploy to a Test and Production environment for your project you will need to configure specific setting values for both testing and production environments depending on the provider.

Configuration settings are accessed at startup using the **AppSettings** class, which is directly tied to the `appSettings.json` config section. The following example gets the value of the **ConnectionString** field that is a property of the **root** node:

    AppSettings.ConnectionString

The setting value is exposed as a property of the `AppSettings` class and reflects the following structure inside the configuration file:

    {
        "ConnectionString": "<ConnectionString>"
    }

The following section describe the app settings sections that are used by the project.

#### Applications settings

The following settings enable specific application features and behaviors using the `AppSettings` class:

| **Key value**                     | **Description**                                          |
|-----------------------------------|----------------------------------------------------------|
| `ConnectionString` | Contains the connection string used to establish a connection to the configured database platform.  | 
| `Logging` | Used for enabling and configuring the logging framework used by the application.  | 
| `Database`  | Determines on which type of database the application is hosted (e.g. LocalDb, SqlServer, AzureSql).  |

**Note:** The application and underlying framework are capable of targetting MySql as the database platform, but this requires some modification in `Startup.cs` as well as adding aditional NuGet packages to support it, see: [MySQL EF Core Database Provider](https://docs.microsoft.com/en-us/ef/core/providers/mysql/).

#### SmartAdmin settings

The following settings enable specific SmartAdmin features and behaviors using the `SmartSettings` class:

| **Key value**                     | **Description**                                          |
|-----------------------------------|----------------------------------------------------------|
| `SmartAdmin:DemoUsername` | Used when seeding the database, this information is shown on the Login page.  | 
| `SmartAdmin:DemoPassword` | Used when seeding the database, this information is shown on the Login page.  | 
| `SmartAdmin:Environment`  | Determines on which type of environment the application is hosted, this is used internally to show additional site features.  | 
| `SmartAdmin:UseShortcuts`  | When set to `true`, enables the 'tiles' feature; this provides large tiles that serve as a quick action window to certain areas inside the application.  | 

#### Asset bundling

The SmartAdmin ASP.NET Core 2.0 project supports the newer bundling setup that was introduced in ASP.NET Core, the configuration of these bundles are now located in the `bundleconfig.json` file. This bundle also contains a pre-defined bundle for the **core** CSS and JS files that should allow you to setup pages that do **not** require any additional plugins. If your page does require them, then these need to be added in the **Scripts** section of the page; you can also register your own bundles to contains a certain set of CSS and/or JS files, i.e. grouping all the Chart plugins or the Calendar + moment library.

### Deploying to Azure

The SmartAdmin for ASP.NET Core 2.0 project is compatible to run hosted in Azure. The following sections describe the steps needed to get the SmartAdmin for ASP.NET Core web app running in Azure as you develop.

#### Create an Azure Web app

To be able to publish the SmartAdmin for ASP.NET Core 2.0 project to Azure, you must first create a new web app in an Azure App Service environment. To learn how to do this, see [How to Create a Web App in an App Service Environment](https://azure.microsoft.com/en-us/documentation/articles/app-service-web-how-to-create-a-web-app-in-an-ase/).

Once you have created your web app, you must create the required app settings. To run the site, you must create a connection string setting for `ConnectionString`. To learn how to do this, see [Configure web apps in Azure App Service](https://azure.microsoft.com/en-us/documentation/articles/web-sites-configure/#application-settings).

#### Create SQL Database

The next step is to create a new Azure SQL Database. To learn how to do this, see [Create your first Azure SQL Database](https://azure.microsoft.com/en-us/documentation/articles/sql-database-get-started/). Once you have created your database in Azure be sure to update the `ConnectionString` value. 

Note that you can use this connection even when running on a local machine, as long as you have created a firewall exception for your local computer. For more information, see [Configure the firewall](https://azure.microsoft.com/en-us/documentation/articles/sql-database-get-started/#step-5-configure-the-firewall).

**Note:** The same applies when developing using a local or network specific SQL Server instance, but take extra precaution to ensure you are **not** directly connecting to the production instance!

#### Publish to Azure

Once you have your web app configured, you can publish the project to Azure. For more information, see [Deploy a web app in Azure App Service](https://azure.microsoft.com/en-us/documentation/articles/web-sites-deploy/).

## Builds

[![SmartAdmin](https://img.shields.io/badge/smartadmin-dev-green.svg)](#shield)

### Tooling and Change Control

The SmartAdmin for ASP.NET Core 2.0 solution uses **Git** as its source control provider which is hosted by [Bitbucket](http://www.bitbucket.org/). This same site provides us with the ability to track issues and publish a Wiki to complement the project. Visual Studio 2017 has built-in support for using Git and thus provides us with a seamless experience.

Using your own source and change control tooling should provide you with a similar if not improved experience depending on best practices and guidelines that you might use internally.

The following tools are highly recommended to be used as a complement to Visual Studio 2017:

- [ReSharper Ultimate 2017](http://www.jetbrains.com/)
- [WebEssentials 2017](http://vswebessentials.com/)

These tools are recommended because of their ability to boost productivity and provide helpers for common scenario's and assists in maintaining the coding guidelines with built-in formatting of the code. As well as provide with easy to access coding snippets and all-rounded support for editing CSS and Javascript.

## Community and Roadmap

To follow along with the development of SmartAdmin for ASP.NET Core 2.0:

- [Changelog](CHANGELOG.md): Displays the changes between each release on SmartAdmin for ASP.NET Core 2.0.
- [Roadmap](https://bitbucket.org/myorange/smartadmin-core-2/wiki/Roadmap): The schedule and milestone themes for SmartAdmin for ASP.NET Core 2.0.

### Helpful Links

- [Introduction to ASP.NET Core](https://docs.microsoft.com/en-us/aspnet/core/index): Contains a brief introduction about the changes for ASP.NET Core 2.0.
- [ASP.NET Core tutorials](https://docs.microsoft.com/en-us/aspnet/core/tutorials/index): Step-by-step guides for developing ASP.NET Core applications.

## Feedback

Check out the [contributing](CONTRIBUTING.md) page to see the best places to log issues and start discussions with the development team of SmartAdmin as well as other users of the SmartAdmin Theme.

### FAQ

> Q: How do you enable bundling in the ASP.NET Core 2.0 project?

Bundling is controlled by the `bundleconfig.json` file in the root of the project. For convinience purposes we have included a `smartadmin.min.css` bundle for the Core CSS files and a `smartadmin.min.js` bundle for the Core JS files. Non-essential plugins are **not** included in this bundle.

If you open the `_Scripts.cshtml` and/or the `_StylesheetsPartial.cshtml` partial in the "Views\Shared" folder, you will see this bundle referenced, but currently commented out. You can uncomment to enable the bundle, but in that case you will have to manually remove the files that are included in the bundle from the partial.

`_StylesheetsPartial.cshtml`

```html
<!-- NOTE: Enable the bundle for faster loading and optimized caching! -->
<link rel="stylesheet" type="text/css" href="~/css/smartadmin.min.css" asp-append-version="true" />
```

`_Scripts.cshtml`

```html
<!-- NOTE: Enable the bundle for faster loading and optimized caching! -->
<script src="~/js/smartadmin.min.js" asp-append-version="true"></script>
```

**Note:** For an optimized experience only include the scripts that each page actually uses to reduce loading time.

### Troubleshooting

As with every out-of-the-box project, there is always a possibility that you encounter errors while using SmartAdmin for ASP.NET Core 2.0. The section below represents the currently known issues and the suggestion on how to address them.

**Note:** This fix has remedied the issue that some of our customers encountered, but could still very well have little to no effect to your specific situation; there are a lot of variables to consider when these types of situations occur.

#### The JavaScript language service has been disabled for the following project(s)

> This error can occur when the new Salsa JavaScript engine is used, which is loaded and enabled by default in the latest versions of Visual Studio 2017.

To address this warning, try adding the following files in their mentioned locations:

- `index.ts` in "wwwroot/js" folder
- `tsconfig.json` in the root of the project (i.e. 'src/SmartAdmin.Seed', 'src/SmartAdmin.Web')

The `index.ts` file should have **no** contents, just leave it empty.
The contents of `tsconfig.json` file should look as follows:

```json
{
    "compilerOptions": {
        "allowJs": true, // These settings apply to .js files as well as .ts files
        "noEmit": true // Do not compile the JS (or TS) files in this project on build
    },
    "include": [
        "wwwroot/js/index.ts" // Include the dummy TypeScript files to satisfy the compiler
    ],
    "exclude": [
        "node_modules", // Don't include any JavaScript found under "node_modules"
        "wwwroot/js/bootstrap", // Don't include any JavaScript found under "wwwroot/js/bootstrap"
        "wwwroot/js/libs", // Don't include any JavaScript found under "wwwroot/js/libs"
        "wwwroot/js/plugin" // Don't include any JavaScript found under "wwwroot/js/plugin"
    ],
    "typeAcquisition": {
        "enable": true // Enable automatic fetching of type definitions for .js libraries
    }
}
```
