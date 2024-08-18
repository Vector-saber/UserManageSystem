<template>
    <div id="container">
        <el-container>
            <el-header>
                <div id="search-lan">
                    <div>
                        <el-select v-model="searchKey"
                        style="width: 240px">
                            <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                        <el-input v-model="searchValue" style="width: 240px" placeholder="Please input" />
                        <el-button size="default" type="primary"  plain @click="getUsers()">Search</el-button>
                    </div>
                    <el-button size="default" type="warning" @click="addUser">Add</el-button>
                </div>
            </el-header>
            <el-main>
                <el-table 
                :border="true"
                :header-cell-style="{ 'text-align': 'center' }"
                :data="users">
                    <el-table-column 
                    prop="id"
                    label="ID"
                    width="80px">
                    </el-table-column>
                    <el-table-column 
                    prop="userName"
                    label="User Name"
                    width="160px">
                    </el-table-column>
                    <el-table-column 
                    prop="trueName"
                    label="True Name"
                    width="160px">
                    </el-table-column>
                    <el-table-column
                    prop="telephone" 
                    label="Telephone"
                    width="200px">
                    </el-table-column>
                    <el-table-column
                    prop="email" 
                    label="Email"
                    width="200px">
                    </el-table-column>
                    <el-table-column 
                    prop="registerDate"
                    label="Register Date"
                    width="200px">
                    </el-table-column>
                    <el-table-column label="Operations">
                         <template  #default="scope">
                            <div class="buttons">
                            <el-button 
                            size="small" 
                            type="primary"
                            @click="editUser(scope.row)"
                           >
                            Edit
                            </el-button>
                            <el-button
                            size="small"
                            type="danger"
                            @click="deleteUser(scope.row.id)"
                            >
                            Delete
                            </el-button>
                            </div>
                         </template>
                    </el-table-column>
                </el-table>
                <el-pagination 
                background 
                layout="prev, pager, next"
                @current-change="getUsers()" 
                v-model:current-page="page"
                v-model:page-size="pageSize"
                :total="total" />
            </el-main>
        </el-container>
    </div>
    <div id="mask" v-show="ispop">
        <div id="pop-up">
            <div id="pop-inputs">
                <div>ID:<el-input v-model="userParam.id" disabled class="pop-input" size="small"></el-input></div>
                <div>UserName:<el-input placeholder="User Name cannot be empty" v-model="userParam.userName" class="pop-input" size="small"></el-input></div>
                <div>TrueName:<el-input v-model="userParam.trueName" class="pop-input" size="small"></el-input></div>
                <div>Telephone:<el-input v-model="userParam.telephone" class="pop-input" size="small"></el-input></div>
                <div>Email:<el-input v-model="userParam.email" class="pop-input" size="small"></el-input></div>
            </div>
            <div id="pop-buttons">
                <el-button size="large" type="primary" @click="ensure">Ensure</el-button>
                <el-button size="large" type="info" @click="cancel">Cancel</el-button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import { ElMessage } from 'element-plus'
export default {
   data(){
        return {
            users: [],
            page: 1,
            pageSize: 10,
            total: 0,
            ispop:false,
            userParam:{
                id: null,
                userName:null,
                trueName:null,
                telephone:null,
                email: null
            },
            searchValue: null,
            searchKey:"id",
            options:[
                {
                    value:"id",
                    label:"ID"
                },
                {
                    value:"user_name",
                    label:"User Name"
                },
                {
                    value:"true_name",
                    label:"True Name"
                }
            ]
        }
    },
    methods:{
        formatDateTime(date, format) {
            const o = {
                'M+': date.getMonth() + 1, // 月份
                'd+': date.getDate(), // 日
                'h+': date.getHours() % 12 === 0 ? 12 : date.getHours() % 12, // 小时
                'H+': date.getHours(), // 小时
                'm+': date.getMinutes(), // 分
                's+': date.getSeconds(), // 秒
                'q+': Math.floor((date.getMonth() + 3) / 3), // 季度
                S: date.getMilliseconds(), // 毫秒
                a: date.getHours() < 12 ? '上午' : '下午', // 上午/下午
                A: date.getHours() < 12 ? 'AM' : 'PM', // AM/PM
            };
            if (/(y+)/.test(format)) {
                format = format.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
            }
            for (let k in o) {
                if (new RegExp('(' + k + ')').test(format)) {
                format = format.replace(
                    RegExp.$1,
                    RegExp.$1.length === 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length)
                );
                }
            }
            return format;
        },
        getUsers(){
            const that = this
            axios.get('/backend/user/getUsersPage',{
                params:{
                    str: this.searchKey,
                    value: this.searchValue==null?"":this.searchValue,
                    currentPage: this.page,
                    pageSize: this.pageSize
                }
            }).then(res=>{
                const data = res.data.data
                that.total = data.total
                for(let i=0; i<data.data.length; i++){
                    data.data[i].registerDate = that.formatDateTime(new Date(data.data[i].registerDate), 'yyyy-MM-dd HH:mm:ss')
                }
                that.users = data.data
            })
        },
        deleteUser(id){
            const that = this
            axios.postForm("/backend/user/deleteUser",{
                 id: id
            }).then(res=>{
                console.log(res)
                that.getUsers()
            })
        },
        setUserParam(id, userName, trueName, telephone, email){

            this.userParam.id = id
            this.userParam.userName = userName
            this.userParam.trueName = trueName
            this.userParam.telephone = telephone
            this.userParam.email = email
            console.log(this.userParam)
        },
        editUser(row){
            this.setUserParam(row.id,row.userName,row.trueName,row.telephone,row.email)
            this.ispop=true
        },
        addUser(){
            this.setUserParam(null,null,null,null,null)
            this.ispop = true
        },
        ensure(){
            const that = this
            if(this.userParam.userName){
                if(this.userParam.id){
                    console.log(this.userParam)
                    axios.postForm("/backend/user/updateUser",{
                        id:this.userParam.id,
                        userName:this.userParam.userName,
                        trueName:this.userParam.trueName,
                        telephone:this.userParam.telephone,
                        email:this.userParam.email
                    }).then((res)=>{
                        console.log(res)
                        that.ispop = false
                        ElMessage({
                            type:"success",
                            message:`Update user ${that.userParam.userName} successfully`
                        })
                        that.setUserParam(null,null,null,null)
                        that.getUsers()
                    })
                }
                else {
                    axios.postForm("/backend/user/addUser",{
                        userName:this.userParam.userName,
                        trueName:this.userParam.trueName,
                        telephone:this.userParam.telephone,
                        email:this.userParam.email
                    }).then((res)=>{
                        console.log(res)
                        that.ispop = false
                        ElMessage({
                            type:"success",
                            message:`Add user ${that.userParam.userName} successfully`
                        })
                        that.setUserParam(null,null,null,null)
                        that.getUsers()
                        
                    })
                }
            }
            else {
                ElMessage({
                    type:"error",
                    message:"User name cannot be empty"
                })
            }
        },
        cancel(){
            this.setUserParam(null,null,null,null,null)
            this.ispop = false
        }
    },
    created(){
        this.getUsers()
    }
}
</script>
<style scoped>
.el-container{
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 0;
}
.el-header {
    background-color:#79bbff;
    width: 1240px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
#search-lan{
    width:1000px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.el-select{
    margin-right: 20px;
}
.el-select + .el-input {
    margin-right: 20px;
}
.el-main {
    width:1240px;
    background-color: #c6e2ff;
    height: 530px;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 10px 20px;
}
.el-table{
    width: 1200px;
    margin-bottom: 20px;
}
.buttons{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
#mask{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 9999;
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
#pop-up {
    width:500px;
    height: 500px;
    background-color: #c6e2ff;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border-radius: 5px;
}
#pop-inputs{
    width: 300px;
    height: 300px;
    background-color:#c6e2ff ;
    display:flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: flex-end;
}
.pop-input{
    width: 200px;
}
#pop-buttons{
    margin-top: 30px;
    width: 300px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
</style>