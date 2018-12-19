import React from 'react'
import ReactDOM from 'react-dom'
import {Provider} from 'react-redux'
import {syncHistoryWithStore} from 'react-router-redux'
import {Router, hashHistory} from 'react-router'

import store from './store/configureStore'

const history = syncHistoryWithStore(hashHistory, store);

const routes = {

  path: '/',
  indexRoute: { onEnter: (nextState, replace) => replace('/home') },
  childRoutes: [
    require('./routes/home').default,


    // require('./routes/dashboard').default,
    // require('./routes/smartadmin-intel').default,
    // require('./routes/widgets').default,
    // require('./routes/outlook').default,
    // require('./routes/tables').default,
    // require('./routes/ui').default,
    // require('./routes/graphs').default,
    // require('./routes/e-commerce').default,
    // require('./routes/misc').default,
    // require('./routes/auth').default,
    // require('./routes/app-views').default,
    // require('./routes/maps').default,
    // require('./routes/calendar').default,
    // require('./routes/forms').default,


    // comment unused routes when develop
    // this will speed up builds
  ]
};

ReactDOM.render((
  <Provider store={store}>
    <Router
      history={history}
      routes={routes}
    />
  </Provider>
), document.getElementById('smartadmin-root'));
