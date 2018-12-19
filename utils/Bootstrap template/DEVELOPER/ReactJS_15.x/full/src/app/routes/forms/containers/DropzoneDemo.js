import React from 'react'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'

import DropzoneInput from '../../../components/forms/inputs/DropzoneInput'


export default class DropzoneDemo extends React.Component {
  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['Forms', 'DropzoneInput']} icon="fa fa-fw fa-pencil-square-o"
                          className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats />
        </div>


        {/* widget grid */}


        <WidgetGrid>

          {/* row */}
          <div className="row">

            {/* NEW WIDGET START */}
            <article className="col-sm-12">

              <p className="alert alert-warning">
                <i className="fa fa-warning fa-fw fa-lg"/><strong>Opps!</strong>
                You may get an error during the upload for this demo. The error will subside once the
                backend portion is properly configured.
              </p>
              <p>
				<span className="label label-warning">
				NOTE</span> &nbsp; This plugins works only on Latest Chrome, Firefox, Safari, Opera &amp; Internet
                Explorer 10.
              </p>

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} color="blueLight">

                <header>
                  <span className="widget-icon"> <i className="fa fa-cloud"/> </span>
                  <h2>My Dropzone! </h2>

                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body">

                    <DropzoneInput options={{
                      addRemoveLinks: true,
                      maxFilesize: 0.5,
                      dictDefaultMessage: '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
                      dictResponseError: 'Error uploading file!'
                    }}>
                      <form action="/api/plug" className="dropzone"/>
                    </DropzoneInput>

                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}

            </article>
            {/* WIDGET END */}

          </div>
        </WidgetGrid>
      </div>
    )
  }
}