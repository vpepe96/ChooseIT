import React from 'react'
import 'script-loader!highcharts'
import 'script-loader!smartadmin-plugins/bower_components/highchartTable/jquery.highchartTable.js'

class HighchartTable extends React.Component {
  componentDidMount() {
    this._renderChart()
  }

  componentWillReceiveProps(nextProps) {
    this._renderChart()
  }

  _renderChart() {
    $(this.refs.table).highchartTable();
  }

  render() {
    let {children, ...props} = {...this.props};
    return (
      <table {...props} ref="table">
        {children}
      </table>
    )
  }
}

export default HighchartTable