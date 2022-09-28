listView('Puppet') {
    description('Puppet Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('puppet.*')
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
