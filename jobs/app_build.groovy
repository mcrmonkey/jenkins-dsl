freeStyleJob('application_build') {
    displayName('Build Application')
    description('Build Application Package')

    parameters {
        choiceParam('ENV', ['dev', 'test', 'prod'])
    }

    checkoutRetryCount(3)

    properties {
        githubProjectUrl('https://github.com/mcrmonkey/demo-app')
    }

    logRotator {
        numToKeep(100)
        daysToKeep(15)
    }

    scm {
        git {
            remote { url('https://github.com/mcrmonkey/demo-app.git') }
            branches('*/main')
            extensions {
                wipeOutWorkspace()
                cleanAfterCheckout()
            }
        }
    }

    triggers {
        githubPush()
    }

    wrappers {
        colorizeOutput()

        // timeout if there has been no activity for 180 seconds
        // then fail the build and set a build description
        timeout {
            noActivity(3600)
            failBuild()
            writeDescription('Build failed due to timeout after {0} minutes')
        }
    }

    steps {
        shell('cd demo-application && make ENV=${ENV} package')
    }

    publishers {
        retryBuild {
            retryLimit(3)
            fixedDelay(15)
        }

        wsCleanup()
    }
}
