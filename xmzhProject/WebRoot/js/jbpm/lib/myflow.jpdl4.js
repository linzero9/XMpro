(function($){
var myflow = $.myflow;

$.extend(true,myflow.config.rect,{
	attr : {
	r : 8,
	fill : '#F6F7FF',
	stroke : '#03689A',
	"stroke-width" : 2
}
});

$.extend(true,myflow.config.props.props,{
	name : {name:'name', label:'流程名称', value:'', editor:function(){return new myflow.editors.inputEditor();}}
	/*key : {name:'key', label:'标识', value:'', editor:function(){return new myflow.editors.inputEditor();}},
	desc : {name:'desc', label:'描述', value:'', editor:function(){return new myflow.editors.inputEditor();}}*/
});


$.extend(true,myflow.config.tools.states,{
	start : {
				showType: 'image',
				type : 'start',
				name : {text:'<<start>>'},
				text : {text:'开始'},
				img : {src : '/js/jbpm/img/48/start_event_empty.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					text: {name:'text',label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'开始'}
					/*temp1: {name:'temp1', label : '文本', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor([{name:'aaa',value:1},{name:'bbb',value:2}]);}}*/
				}},
			end : {showType: 'image',type : 'end',
				name : {text:'<<end>>'},
				text : {text:'结束'},
				img : {src : '/js/jbpm/img/48/end_event_terminate.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					text: {name:'text',label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'结束'}
				/*	temp1: {name:'temp1', label : '文本', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor([{name:'aaa',value:1},{name:'bbb',value:2}]);}}*/
				}},
			'end-cancel' : {showType: 'image',type : 'end-cancel',
				name : {text:'<<end-cancel>>'},
				text : {text:'取消'},
				img : {src : '/js/jbpm/img/48/end_event_cancel.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					text: {name:'text',label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'取消'}
					/*temp1: {name:'temp1', label : '文本', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor([{name:'aaa',value:1},{name:'bbb',value:2}]);}}*/
				}},
			'end-error' : {showType: 'image',type : 'end-error',
				name : {text:'<<end-error>>'},
				text : {text:'错误'},
				img : {src : '/js/jbpm/img/48/end_event_error.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					text: {name:'text',label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'错误'}
				/*	temp1: {name:'temp1', label : '文本', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor([{name:'aaa',value:1},{name:'bbb',value:2}]);}}*/
				}},
			state : {showType: 'text',type : 'state',
				name : {text:'<<state>>'},
				text : {text:'状态'},
				img : {src : '/js/jbpm/img/48/task_empty.png',width : 48, height:48},
				props : {
					text: {name:'text',label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'状态'}
					/*temp1: {name:'form', label : '文本', value:'22', editor: function(){return new myflow.editors.inputEditor();}}*/
					/*temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor([{name:'aaa',value:1},{name:'bbb',value:2}]);}}*/
				}},
			fork : {showType: 'image',type : 'fork',
				name : {text:'<<fork>>'},
				text : {text:'分支'},
				img : {src : '/js/jbpm/img/48/gateway_parallel.png',width :48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					text: {name:'text', label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'分支'}
				/*	temp1: {name:'temp1', label: '文本', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor('select.json');}}*/
				}},
			join : {showType: 'image',type : 'join',
				name : {text:'<<join>>'},
				text : {text:'合并'},
				img : {src : '/js/jbpm/img/48/gateway_parallel.png',width :48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					text: {name:'text', label: '显示', value:'', editor: function(){return new myflow.editors.textEditor();}, value:'合并'}
					/*temp1: {name:'temp1', label: '文本', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					temp2: {name:'temp2', label : '选择', value:'', editor: function(){return new myflow.editors.selectEditor('select.json');}}*/
				}},
			task : {showType: 'text',type : 'task',
				name : {text:'<<task>>'},
				text : {text:'任务'},
				img : {src : '/js/jbpm/img/48/task_empty.png',width :48, height:48},
				props : {
					text: {name:'text', label: '显示',value:'',editor: function(){return new myflow.editors.textEditor();}},
					/*assignee: {name:'assignee', label: '', value:''},*/
					form: {name:'form', label : '表单',value:'',editor: function(){return new myflow.editors.inputEditor();}}
					/*desc: {name:'desc', label : '', value:''}*/
				}},
			task1: {showType: 'text',type : 'task',
				name : {text:'<<task>>'},
				text : {text:'模式一'},
				img : {src : '/js/jbpm/img/48/task_empty.png',width :48, height:48},
				props : {
					text: {name:'text', label: '模式名称',value:'模式一',editor: function(){return new myflow.editors.textEditor();}},
					form: {name:'form', label : '',value:'/Generalprocess/generalProcessAction_toModelOne.action'},
					assignee: {name:'assignee', label: '', value:'#{user}'}
				}},
			task2: {showType: 'text',type : 'task',
				name : {text:'<<task>>'},
				text : {text:'模式二'},
				img : {src : '/js/jbpm/img/48/task_empty.png',width :48, height:48},
				props : {
					text: {name:'text', label: '模式名称',value:'模式二',editor: function(){return new myflow.editors.textEditor();}},
					form: {name:'form', label : '',value:'/Generalprocess/generalProcessAction_toModelTwo.action'},
					assignee: {name:'assignee', label: '', value:'#{user}'}
				}},
			task3: {showType: 'text',type : 'task',
				name : {text:'<<task>>'},
				text : {text:'模式三'},
				img : {src : '/js/jbpm/img/48/task_empty.png',width :48, height:48},
				props : {
					text: {name:'text', label: '模式名称',value:'模式三',editor: function(){return new myflow.editors.textEditor();}},
					form: {name:'form', label : '',value:'moshi3.action'}
				}}
				
});
})(jQuery);