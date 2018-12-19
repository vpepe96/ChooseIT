import  React from 'react'

import apiPanelStore from '../stores/apiPanelStore'
import {Provider} from 'react-redux'

import JCrop from '../components/JCrop'
import Fields from '../components/Fields'
import ApiPanelControls from './ApiPanelControls'

export default ()=>(
    <Provider store={apiPanelStore}>
        <div>
            <section>
                <JCrop store={apiPanelStore}
                       src="assets/img/superbox/superbox-full-7.jpg" width={600} height={400}/>
            </section>
            <section className="card">
                {/*
                 <Fields />
                 */}
                <ApiPanelControls />
            </section>
        </div>
    </Provider>
);
