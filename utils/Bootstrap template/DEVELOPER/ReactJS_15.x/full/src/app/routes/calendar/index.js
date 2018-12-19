/**
 * Created by griga on 11/19/16.
 */


export default {
  component: require('../../components/common/Layout').default,
  childRoutes: [{
    path: 'calendar',
    getComponent: (nextState, cb)=>{
      System.import('./containers/CalendarPage').then( m => {
        cb(null, m.default)
      })
    }
  }]
}