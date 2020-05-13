# SiiliWall Project Backend

## How to Setup SiiliWall Backend

How do I get backend to work?
1.	Clone backend to your computer and open it with an editor program for example IntelliJ or Eclipse.
2.	Open application.properties -file. You can find it from /src/main/resources. Keep it open because soon you will make changes to the configurations.
3.	Create credentials in Heroku.com
4.	In Heroku, create new app (New App -> Create New App)
5.	Name the app and set location as Europe (original name was ‘siiliwall’ so if that is not available, come up with a new one.
6.	Go to `https://data.heroku.com/` and open the Heroku-project you created.
7.	Go to Settings tab and click ‘View Credentials’
*ATTENTION!* Here you will find the credentials that need to be edited in application.properties -file in your backend. Push changes to GitHub.

8.	Open project in Heroku (dashboard.heroku.com) and go to ‘Deploy’ tab
*	Choose Deploy Method – GitHub
*	App Connect to GitHub – pick the backend repository from GitHub
*	Manual Deploy – choose deployment branch that is used to build the project (ie. Master)
*	Automatic Deploys – click “Enable Automatic Deploys”
9.	Wait for App to finish build.
10.	Go to projects Heroku-page and click ’Open App’ from top right.
Currently the App gives a Whitelabel Error since no root URL is determined.
Backend and Database are successfully built if you can see JSON-data on the following page:
`PROJECTNAME/herokuapp.com/boards`
(boards-endpoint is determined in RestController-file in backend)

## Tech
java version "1.8.0_241"

## Starting of daily work






Aloitus aina `git status`
Start your workday with `git status`

To see commit-history use `git log`

Check your current branch `git branch`

Your are able to switch branch with `git checkout branchName`

File changes to previous version can be checked by using command diff. 

`git diff fileName`

## Changing commit or removing of unneeded commit

If you forgot something from your commit or you typed commit wrong,
Your are able to fill in the latest commit by using --amend.
Add changes and do commit:
`git commit --amend`

If you added a file to the next commit(add), that you did not want to add, you can abort the staging with command reset:
`git reset HEAD fileName` # HEAD refers to the latest version

If you want to abandon your changes in file and go back to a version in the version control, it is possible with checkout.
`git checkout –- fileName`

DISCLAIMER: remember, that every commit, which has been saved is restoreable. Therefore your should make as many commits as possible.

## Simple model, that is been used in this project, where everyone has the rights to write in repository works like written below:

1. Firstly everyone must clone the shared repository

`git clone <repository-url>`

2. Changes will be made in the repository with basic commands

`git add fileName` # stage one file

`git add .` # stage everything

`git commit -m "message goes here"`

3. Push changes to shared repository

`git push origin master` # remote-repository origin, changes in branch

4. Other people changes can be fetched in your own repository, merged and pushed.

`git fetch origin`

`git merge origin/master`

`git push origin master` # pushes changes to master branch

### Merge instructions (from branch to master)

Step 1. Write `git checkout master` in order to go master branch

Step 2. Write `git merge` branchName

Step 3. Enter writing mode by pressing i on your keyboard.

Step 4. Write message message is displayed in yellow color.

Step 5. Exit writing mode by pressing esc key on your keyboard.

Step 6. Finish merging process by writing :wq and pressing enter on your keyboard.

### Making pull request

Changes coming from pull request should be always done in feature-branches. # example feature/development

Pulling is just doing a fetch followed by a merge. If you know your branch is clean (e.g., master branch), go ahead and get the latest changes. There will be no merge conflicts as long as your branch is clean.

Command `git pull`

## Naming convention used in branching

All branches are named with lower cases

Create a new branch:

`git branch branchName`

Fast way for creating and hopping in the branch:

`git  checkout –b branch` # creates branch and switches there

If you have no use for branch, you can delete it with -d (--delete).

`git  branch –d branch`

<<<<<<< HEAD
-- make documentation in English
-- Topics needed in documentation
1. Merge instructions
2. Removing of unneeded commit
3. Starting of Daily work
4. Naming convention used in branching
5. Convention of commit messages
6. Acceptance criteria of putting something to git
7. Ending of daily work
8. Possible external resources/links used define how git is used



## Jos haluat lisätä tiedoston repositoryyn.
=======
## Convention of commit messages
>>>>>>> 92967fd54a43b69ca253ce930aaf4d09b8fcfc0e

A properly formed git commit subject line should always be able to complete the following sentence

`If applied, this commit will <your subject line here>`

### Information in commit messages

* Describe why a change is being made.
* How does it address the issue?
* What effects does the patch have?
* Do not assume the reviewer understands what the original problem was.
* Do not assume the code is self-evident/self-documenting.
* Read the commit message to see if it hints at improved code structure.
* The first commit line is the most important.
* Describe any limitations of the current code.
* Do not include patch set-specific comments.

## Acceptance criteria of putting something to git

Test code.

Code review with project team members and learning process.

Code review with the boss.

### Delete commit using commit id you can find commit id from github commits. Id contains 8 characters or/and digits

Write `git push origin +id^: master`

## Useful commands

Write `git branch -a` to display all branches

Write `git status` to display files containing changes.

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
