const report = require('multiple-cucumber-html-reporter');

report.generate({
    jsonDir: './test/report/',
    reportPath: './test/report/',
    reportName: 'Automated Report',
    pageFooter:'Baufest',
    displayReportTime: true,
    plainDescription:true,
    openReportInBrowser: true,
    displayDuration: true,
    useCDN: true,

    metadata:{
        browser: {
            name: 'chrome',
            version: '113'
        },
        device: 'Local test machine',
        platform: {
            name: 'Windows',
              version: '10 Pro'
        },
    },


    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Demoblaze'},
            {label: 'Release', value: 'MVP 1.0'},
            {label: 'Browser', value: 'chrome'},
            {label: 'Environment', value: 'Test'}
        ]
    }
}
)
;
