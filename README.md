# Siili Wall Project

## Starting of daily work:

Start your workday with `git status`

To see commit-history use `git log`

Check your current branch `git branch`

Your are able to switch branch with `git checkout branchName`

File changes to previous version can be checked by using command diff. 
`git diff fileName`

If you forgot something from your commit or you typed commit wrong,
Your are able to fill in the latest commit by using --amend.
Add changes and do commit:
`git commit --amend`

If you added a file to the next commit(add), that you did not want to add, you can abort the staging with command reset:
`git reset HEAD fileName` # HEAD refers to the latest version

If you want to abandon your changes in file and go back to a version in the version control, it is possible with checkout.
`git checkout –- fileName`

DISCLAIMER: remember, that every commit, which has been saved is restoreable. Therefore your should make as many commits as possible.

Simple model, that is been used in this project, where everyone has the rights to write in repository works like written below:

1. Firstly everyone must clone the shared repository
`git clone <repository-url>`

2. Changes will be made in the repository with basic commands
`git add fileName`
`git commit`

3. Push changes to shared repository
`git push origin master` # remote-repository origin, changes in branch

4. Other people changes can be fetched in your own repository, merged and pushed.
`git fetch origin`
`git merge origin/master`
`git push origin master`

Making pull request:

Command `git pull`

Changes coming from pull request should be always done in feature-branches. # example feature/development

If changes has been pulled, you can get your own changes back in your own repository from master-branch with pull command.

## Naming convention used in branching:

All branches are named with lower cases

Create a new branch:

`git branch branchName`

Fast way for creating and hopping in the branch:

`git  checkout –b branch` # creates branch and switches there

If you have no use for branch, you can delete it with -d (--delete).

`git  branch –d branch`

## Add new file/files to github repository.

`Step 1. Go to project folder`

`Step 2. Write git add . to add all files to repository don't use this all the time.`

`Step 2. Write git add file name to add sigle file to github repository.`

`Step 3. Write git commit -m "message goes here.`

`Step 4. Write git push origin master to push changes to master branch replace master with other branch name when you push to github.`

`Step 5. Write git checkout branch name to change current working branch.`

## Delete commit using commit id you can find commit id from github commits id contains 8 charecters, digits.

`Write git push origin +id^: master`

## Useful commands.

`Write git branch -a to display all branches`

`Write git status to display files containing changes.`


## In case you want to merge branch to master.

`Step 1. Write git checkout master in order to go master branch`

`Step 2. Write git merge branchName`

`Step 3. Enter writing mode by pressing i on your keyboard.`

`Step 4. Write message message is displayed in yellow color.`

`Step 5. Exit writing mode by pressing esc key on your keyboard.`

`Step 6. Finish merging process by writing :wq and pressing enter on your keyboard.`

## Ending of daily work

## Tool versions and links
[Node.js -version 12.14.1 LTS](https://nodejs.org/en/)

[React.js -version 16.12](https://reactjs.org/versions)

[Java -version 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Springboot -version 2.2.4.RELEASE](https://spring.io/projects/spring-boot)

[Visual Studio Code](https://code.visualstudio.com/)

[IntelliJ IDEA](https://www.jetbrains.com/idea/)
   
## Possible external resources/links used define how git is used

[ADD LINK NAME HERE](ADD LINK URL HERE)
