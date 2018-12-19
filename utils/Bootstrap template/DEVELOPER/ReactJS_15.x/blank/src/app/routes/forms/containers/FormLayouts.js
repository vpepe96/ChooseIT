import React from 'react'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'

import CheckoutForm from '../components/layouts/CheckoutForm'
import OrderForm from '../components/layouts/OrderForm'
import ReviewForm from '../components/layouts/ReviewForm'
import RegistrationForm from '../components/layouts/RegistrationForm'
import CommentForm from '../components/layouts/CommentForm'
import ContactsForm from '../components/layouts/ContactsForm'

export default class FormLayouts extends React.Component {
  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['Forms', 'Form Layouts']} icon="fa fa-fw fa-pencil-square-o"
                          className="col-xs-12 col-sm-9 col-md-9 col-lg-9"/>

          <div className="col-xs-12 col-sm-3 col-md-3 col-lg-3">
            {/* Button trigger modal */}
            {/*<a onClick="openModal()" className="btn btn-success btn-lg pull-right header-btn hidden-mobile"><i
              className="fa fa-circle-arrow-up fa-lg"/> Launch form modal</a>*/}
          </div>
        </div>


        <div className="alert alert-block alert-success">

          <h4 className="alert-heading"><i className="fa fa-check-square-o"/> Check validation!</h4>

          <p>
            You may also check the form validation by clicking on the form action button. Please try and see the results
            below!
          </p>
        </div>

        {/* widget grid */}

        <WidgetGrid>


          {/* START ROW */}

          <div className="row">

            {/* NEW COL START */}
            <article className="col-sm-12 col-md-12 col-lg-6">

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} custombutton={false}>

                <header>
                  <span className="widget-icon"> <i className="fa fa-edit"/> </span>

                  <h2>Checkout Form </h2>

                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body no-padding">

                    <CheckoutForm />

                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} custombutton={false}>

                <header>
                  <span className="widget-icon"> <i className="fa fa-edit"/> </span>

                  <h2>Order form </h2>

                </header>

                {/* widget div*/}
                <div>

                  {/* widget content */}
                  <div className="widget-body no-padding">

                    <OrderForm />

                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} custombutton={false}>

                <header>
                  <span className="widget-icon"> <i className="fa fa-edit"/> </span>

                  <h2>Review form </h2>

                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body no-padding">

                    <ReviewForm />

                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}

            </article>
            {/* END COL */}

            {/* NEW COL START */}
            <article className="col-sm-12 col-md-12 col-lg-6">

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} custombutton={false}>

                <header>
                  <span className="widget-icon"> <i className="fa fa-edit"/> </span>

                  <h2>Registration form</h2>

                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body no-padding">

                    <RegistrationForm />

                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} custombutton={false}>

                <header>
                  <span className="widget-icon"> <i className="fa fa-edit"/> </span>

                  <h2>Comment form </h2>

                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body no-padding">

                    <CommentForm />


                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}


              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget editbutton={false} custombutton={false}>

                <header>
                  <span className="widget-icon"> <i className="fa fa-edit"/> </span>

                  <h2>Contacts form </h2>

                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body no-padding">

                    <ContactsForm />

                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}


            </article>
            {/* END COL */}

          </div>

          {/* END ROW */}

        </WidgetGrid>

        {/* end widget grid */}

      </div>
    )
  }
}