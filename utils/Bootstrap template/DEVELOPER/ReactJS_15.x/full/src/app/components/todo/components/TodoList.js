import React from 'react'
import classnames from 'classnames'
import {findDOMNode} from 'react-dom'

import Moment from '../../utils/Moment'

import TodoActions from '../actions/TodoActions'
import TodoStore from '../stores/TodoStore'

export default class TodoList extends React.Component{
    _toggleItem =(item) =>{
        TodoActions.toggleTodo(item)
    }
    _deleteItem =(item) =>{
        TodoActions.deleteTodo(item)
    }
    componentDidMount () {
        $(findDOMNode(this.refs.todoList)).sortable({
            handle: '.handle',
            connectWith: ".todo",
            receive: (event, ui) => {
                let item = TodoStore.getItemById(
                    $(ui.item).data('todoId')
                );
                item.type = this.props.type
                TodoActions.updateTodo(item)
                ui.sender.sortable("cancel");
            }
        }).disableSelection();
    }
    shouldComponentUpdate(nextProps, nextState){
        return nextProps.items.length != this.props.items.length
    }
    render () {
        return (
            <div>
                <h5 className="todo-group-title"><i
                    className={classnames('fa', 'fa-'+this.props.icon)}/>{this.props.title}(
                    <small className="num-of-tasks">{this.props.items.length}</small>
                    )
                </h5>
                <ul className="todo" ref="todoList">
                    {this.props.items.map((item, idx)=>{
                        return (
                        <li className={classnames({complete: item.completedAt})} key={item._id} data-todo-id={item._id}>
    	                    <span className="handle"><label className="checkbox">
                                <input type="checkbox" onClick={this._toggleItem.bind(this, item)}
                                       defaultChecked={item.completedAt} name="checkbox-inline"/>
                                <i /></label></span>
                            <p>
                            <strong>Ticket #{idx + 1}</strong><em> - </em><big>{item.title}</big>
                            <span className="text-muted">{item.description}</span>
                            <span className="date"><Moment date={item.createdAt}/></span>
                                <button
                                    onClick={this._deleteItem.bind(this, item)}
                                    className="btn btn-link btn-xs"><i
                                    className="fa fa-trash"/></button>
                            </p>
                        </li>
                            )
                        })}
                </ul>
            </div>
        )
    }
}