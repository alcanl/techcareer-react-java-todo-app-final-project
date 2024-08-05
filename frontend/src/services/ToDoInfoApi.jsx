
// http://localhost:4444/blog/category/api/v1/delete/all
// proxy:    http://localhost:4444/
// persist:  blog/category/api/v1
// URL:      /delete/all

import axios from "axios";

// PERSIST
const TODO_INFO_API_PERSIST_URL="/todo/api/v1"

// ToDoInfoApi
class ToDoInfoApi {

    toDoApiDeleteAll() {
        return axios.delete(`${TODO_INFO_API_PERSIST_URL}/delete/all`);
    }

    toDoApiCreate(toDoInfoDto) {
        return axios.post(`${TODO_INFO_API_PERSIST_URL}/save`,toDoInfoDto)
    }

    toDoApiList() {
       return axios.get(`${TODO_INFO_API_PERSIST_URL}/get/all`);
    }

    toDoApiFindById(id) {
        return axios.get(`${TODO_INFO_API_PERSIST_URL}/get/${id}`);
    }

    toDoApiUpdate(id, toDoInfoDto) {
        return axios.put(`${TODO_INFO_API_PERSIST_URL}/update`,toDoInfoDto);
    }

    toDoApiDeleteById(id) {
        return axios.delete(`${TODO_INFO_API_PERSIST_URL}/delete/${id}`);
    }
} //end class ToDoInfoApi

// Export Default
export default new ToDoInfoApi();