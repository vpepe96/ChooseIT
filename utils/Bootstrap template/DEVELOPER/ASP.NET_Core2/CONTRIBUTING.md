# How to contribute

One of the easiest ways to contribute is to participate in discussions and discuss issues. You can also contribute by submitting pull requests with code changes if you have been invited to join the EAP program, or by emailing one of the authors.


## General feedback and discussions?

- Please start a discussion on the [issue tracker](https://bitbucket.org/myorange/smartadmin-core-2/issues?status=new&status=open) if you have been granted access.
- Use one of the mentioned direct support email addresses

**Note:** Response times may take anywhere between 1 to 5 business days depending on the urgency of the support request and availability.


## Bugs and feature requests?

For non-security related bugs please log a new issue under the appropriate component. Here are some of the most common components:

* **Database**: Anything that relates to the entity models and the connection to the database.
* **Configuration**: Anything that relates to the configuration that the application relies on to run.
* **Theme**: Anything that relates to the SmartAdmin theme itself, this can be styling issues or other.

#### Email support

- For SmartAdmin specific bugs please mail to: `support_at_myorange_dot_ca`

Bugs will be addressed on a per-case basis and as long as the bug originated from the project as it exists in the downloaded archive. If the bug is a by-product of local modifications then support will require a separate agreement of time spend to address the issue and requires a support fee (hourly) to be paid upfront.

New features and integrations will not be handled by regular support; these cases will always require a specific agreement and will only be carried out after both parties agree to the terms and conditions that may be applicable, such as an hourly fee.

**Note:** Due to the overwhelming amount of customers and support requests we have gained over the past years, any filed support requests for licenses **older than 3-months** can no longer be processed for free. Handling these issues will require a separate agreement and are liable to an hourly fee.

## Reporting security issues and bugs

Security issues and bugs should be reported privately, via email, to the MyOrange Security department: `security_at_myorange_dot_ca`. You should typically receive a response within 24 hours. If for some reason you do not, please follow up via email to ensure we received your original message.

**Note:** Security issues are treated with the utmost urgency, so please respect the purpose of this mailbox, abuse will lead to us having to revoke your support request privileges.

## Other discussions

Our team members also monitor several other discussion forums:

* [Wrapbootstrap](https://wrapbootstrap.com/theme/smartadmin-responsive-webapp-WB0573SK0): Comments are read and responded to on a per-case basis and in order of submission.

## Filing issues
When filing issues, please use the [bug filing templates](https://github.com/aspnet/Home/wiki/Functional-bug-template) that has been kindly provided by the ASP.NET Team.
The best way to get your bug fixed is to be as detailed as you can be about the problem.
Providing a minimal project with steps to reproduce the problem is ideal.
Here are questions you can answer before you file a bug to make sure you're not missing any important information.

1. Did you read the documentation?
2. Did you include the snippet of broken code in the issue?
3. What are the *EXACT* steps to reproduce this problem?
4. What package versions are you using (you can see these in the `.csproj` file)?
5. What operating system are you using?
6. What version of IIS are you using?
7. What browser and version are you using?
8. What version of SmartAdmin are you using?

Bitbucket supports [markdown](https://help.github.com/articles/github-flavored-markdown/), so when filing bugs make sure you check the formatting before clicking submit.

## Contributing code and content

**Identifying the scale**

If you would like to contribute to one of our repositories, first identify the scale of what you would like to contribute. If it is small (grammar/spelling or a bug fix) feel free to start working on a fix. If you are submitting a feature or substantial code contribution, please discuss it with the team and ensure it follows the product roadmap. You might also read these two blogs posts on contributing code: [Open Source Contribution Etiquette](http://tirania.org/blog/archive/2010/Dec-31.html) by Miguel de Icaza and [Don't "Push" Your Pull Requests](https://www.igvita.com/2011/12/19/dont-push-your-pull-requests/) by Ilya Grigorik. Note that all code submissions will be rigorously reviewed and tested by the MyOrange SmartAdmin development team, and only those that meet an high bar for both quality and design/roadmap appropriateness will be merged into the source.

**Obtaining the source code**

If you are an outside contributer, please fork the SmartAdmin for ASP.NET Core 2.0 repository you would like to contribute to your account. See the Bitbucket documentation for [forking a repo](https://bitbucket.org/) if you have any questions about this. 

**Submitting a pull request**

You will need to have joined the SmartAdmin EAP program before being capable of submitting your pull request. To join the Early Access Program (EAP), you will need to submit a request via the form and then electronically sign the EAP when you receive the email containing the link to the document. This needs to only be done once for any SmartAdmin project.

If you don't know what a pull request is read this article: [Using pull requests](https://help.github.com/articles/using-pull-requests). Make sure the respository can build and all tests pass. Familiarize yourself with the project workflow and our coding conventions. The coding, style, and general engineering guidelines are published on the [Engineering guidelines](https://github.com/aspnet/Home/wiki/Engineering-guidelines) page for ASP.NET and are embraced by the SmartAdmin team members.

Pull requests should all be done to the **development** branch (not master). 

**Commit/Pull Request Format**

```
Summary of the changes (Less than 80 chars)
 - Detail 1
 - Detail 2

Addresses #bugnumber (in this specific format)
```

**Tests**

-  Tests need to be provided for every bug/feature that is completed.
-  Tests only need to be present for issues that need to be verified by QA (e.g. not tasks)
-  If there is a scenario that is far too hard to test there does not need to be a test for it.
  - "Too hard" is determined by the team as a whole.

**Feedback**

Your pull request will then go through extensive checks by the subject matter experts on our team. Please be patient; we have several of pull requests across all of our repositories. Update your pull request according to feedback until it is approved by one of the SmartAdmin team members. After that, one of our team members will add the pull request to **development** and it will become part of the next upcoming release of SmartAdmin!

**Note:** Credit will be given to your full name or username upon request along with the changelog entry.
