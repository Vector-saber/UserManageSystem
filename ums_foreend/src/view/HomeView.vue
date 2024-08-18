<template>
    <div id="container">
        <el-container>
            <el-header>
                Header
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
                            
                           >
                            Edit
                            </el-button>
                            {{ scope.row.id }}
                            <el-button
                            size="small"
                            type="danger"
                            
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
</template>

<script>
import axios from 'axios'
export default {
   data(){
        return {
            users: [],
            page: 1,
            pageSize: 10,
            total: 0,
            searchValue: null,
            searchKey:"id",
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
</style>