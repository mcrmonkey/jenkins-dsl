listView('Packer') {
    description('Packer builds')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('packer.*')
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
