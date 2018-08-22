# Guidelines for contribution

## 1. Create a Branch for each new feature or bugfix
Whenever you begin work on a new feature or bugfix, it's important that you create a new branch. Not only is it proper git workflow, but it also keeps your changes organized and separated from the master branch so that you can easily submit and manage multiple pull requests for every task you complete.

### First checkout the master branch:
Checkout the master branch - you want your new branch to come from master

    git checkout master

### Next create a new branch named <feature-name> (give your branch its own simple informative name)
    git branch feature-name

### Switch to your new branch
    git checkout feature-name
Now, go to town hacking away and making whatever changes you want to.

[P.S. Make sure to follow these guidelines when making commits](https://chris.beams.io/posts/git-commit/)

the commands for branching and checking out can be run together using the command `git checkout -b feature-name`)

## 2. Open a pull request on GitHub

After you have completed work on a feature and feel like it is ready to be included into the main code-base, open a pull request.

Before that you have to make sure that your local repository is up to date with the version on github.

### First make sure you are on your feature branch:

the `git branch` command will give you a list of branches and **highlight*** the one you are working on. Make sure that the branch which is highlighted is your feature branch. if not run the following command,

    git checkout your-feature-branch-name 

### next pull changes from the master branch of the remote repository into your feature branch 

_****This step is important to avoid merge conflicts**_

the `git pull` command performs two operations together, a **fetch** which downloads changes from the remote repository and a **merge** which merges those changes into the current branch. 

    git pull origin master
The command above will merge changes from the master branch on the remote repository into your feature branch. 

### Finally push your changes and submit it in a pull request
push your changes to the feature branch with the flowing command,

    git push -u origin feature-branch-name
_**the -u flag is used to automatically set the upstream branch, this only has to be done during the first push**_
 
Once you've committed and pushed all of your changes to GitHub, go to the page for the project on GitHub, select your development branch, and click the pull request button. 

If you need to make any adjustments to your pull request, just push the updates to GitHub. Your pull request will automatically track the changes on your development branch and update.

**When creating a pull request, assign a team member as a reviewer so you can get a second opinion on the code.**



