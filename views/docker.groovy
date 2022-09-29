listView('Docker') {
    description('Docker jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('docker.*')
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
