import React from 'react'
import Reflux from 'reflux'
import classnames from 'classnames'

import JarvisWidget from '../../widgets/JarvisWidget'
import TodoStore from '../stores/TodoStore'
import TodoActions from '../actions/TodoActions'

import TodoList from './TodoList'
import TodoForm from './TodoForm'

export default class TodoWidget extends Reflux.Component{

  constructor(props){
        super(props)
        this.state = TodoStore.getData()
        this.store = TodoStore
    }
    _toggleAdd(){
        TodoActions.toggleNewTodo()
    }
    render () {
        return (
            <JarvisWidget editbutton={false} color="blue">
                <header>
                    <span className="widget-icon"><i className="fa fa-check txt-color-white"/></span>

                    <h2> ToDo's </h2>

                    <div className="widget-toolbar">
                        {/* add: non-hidden - to disable auto hide */}
                        <button className={classnames(["btn btn-xs btn-default", {
                            active: this.state.newTodo
                        }])} onClick={this._toggleAdd}><i className={classnames({ 'fa fa-plus': !this.state.newTodo, 'fa fa-times': this.state.newTodo})}/> Add</button>

                    </div>
                </header>
                {/* widget div*/}
                <div>
                    <div className="widget-body no-padding smart-form">

                        <div className={classnames({
                            'hidden': !this.state.newTodo
                        })}>
                            <h5 className="todo-group-title"><i className="fa fa-plus-circle"/> New Todo</h5>
                            <TodoForm />
                        </div>

                        <TodoList type="Critical" title="Critical Tasks" icon="warning" items={this.state.items.filter((item)=>(item.type == 'Critical'))}/>

                        <TodoList type="Important" title="Important Tasks" icon="exclamation" items={this.state.items.filter((item)=>(item.type == 'Important'))}/>

                        <TodoList type="Completed" title="Completed Tasks" icon="check" items={this.state.items.filter((item)=>(item.type == 'Completed'))}/>

                        {/* end content */}
                    </div>

                </div>
                {/* end widget div */}
            </JarvisWidget>
        )
    }
}