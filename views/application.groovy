listView('Application') {
    description('Application build jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('application.*')
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}
