

export default {
  path: 'graphs',
  component: require('../../components/common/Layout').default,

  childRoutes: [

    {
      path: 'flot',
      getComponent(nextState, cb){
        System.import('./containers/FlotCharts').then((m)=> {
          cb(null, m.default)
        })
      }
    },

    {
      path: 'chartjs',
      getComponent(nextState, cb){
        System.import('./containers/ChartJs').then((m)=> {
          cb(null, m.default)
        })
      }
    },

    {
      path: 'morris',
      getComponent(nextState, cb){
        System.import('./containers/MorrisCharts').then((m)=> {
          cb(null, m.default)
        })
      }
    },

    {
      path: 'sparklines',
      getComponent(nextState, cb){
        System.import('./containers/SparklineCharts').then((m)=> {
          cb(null, m.default)
        })
      }
    },

    {
      path: 'easy-pie-charts',
      getComponent(nextState, cb){
        System.import('./containers/EasyPieCharts').then((m)=> {
          cb(null, m.default)
        })
      }
    },

    {
      path: 'dygraphs',
      getComponent(nextState, cb){
        System.import('./containers/Dygraphs').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'highchart-table',
      getComponent(nextState, cb){
        System.import('./containers/HighchartTables').then((m)=> {
          cb(null, m.default)
        })
      }
    },


  ]


};
