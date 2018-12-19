import  React from 'react'

import {Provider} from 'react-redux'
import previewPanelStore from '../stores/previewPanelStore'

import JCrop from '../components/JCrop'
import Fields from '../components/Fields'

export default ()=>(
    <Provider store={previewPanelStore}>
        <div>
            <section>
                <JCrop store={previewPanelStore}
                       src="assets/img/superbox/superbox-full-9.jpg" width={600} height={400}/>
            </section>
            <section>
                <Fields />
            </section>
        </div>
    </Provider>
);
