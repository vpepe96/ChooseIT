/**
 * Created by griga on 11/18/16.
 */


export default {
  component: require('../../components/common/Layout').default,

  childRoutes: [
    {
      path: 'outlook',
      indexRoute: { onEnter: (nextState, replace) => replace('/outlook/folder/inbox') },

      getComponent(nextState, cb){
        System.import('./containers/Outlook').then((m)=> {
          cb(null, m.default)
        })
      },

      childRoutes: [
        {
          path: 'folder/:folder',
          getComponent(nextState, cb){
            System.import('./containers/OutlookFolder').then((m)=> {
              cb(null, m.default)
            })
          }
        },
        {
          path: 'detail/:id',
          getComponent(nextState, cb){
            System.import('./containers/OutlookDetail').then((m)=> {
              cb(null, m.default)
            })
          }
        },
        {
          path: 'replay/:id',
          getComponent(nextState, cb){
            System.import('./containers/OutlookReplay').then((m)=> {
              cb(null, m.default)
            })
          }
        },
        {
          path: 'compose',
          getComponent(nextState, cb){
            System.import('./containers/OutlookCompose').then((m)=> {
              cb(null, m.default)
            })
          }
        },
      ]
    }
  ]
};
