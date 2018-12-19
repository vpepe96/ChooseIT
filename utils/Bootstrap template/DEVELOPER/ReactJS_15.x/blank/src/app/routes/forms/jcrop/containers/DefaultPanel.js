import  React from 'react'

import {Provider} from 'react-redux'
import defaultBehaviorStore from '../stores/defaultDemoStore'

import JCrop from '../components/JCrop'
import Fields from '../components/Fields'
import ApiPanelControls from './ApiPanelControls'

export default ()=>(
    <Provider store={defaultBehaviorStore}>
        <div>
            <section>
                <JCrop

                    store={defaultBehaviorStore} src="assets/img/superbox/superbox-full-11.jpg" width={600} height={400}/>
            </section>
        </div>
    </Provider>
);
