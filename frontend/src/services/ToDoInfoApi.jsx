
// http://localhost:4444/blog/category/api/v1/delete/all
// proxy:    http://localhost:4444/
// persist:  blog/category/api/v1
// URL:      /delete/all

import axios from "axios";

// PERSIST
const TODO_INFO_API_PERSIST_URL="/todo/api/v1"

// ToDoInfoApi
class ToDoInfoApi {

    // SPEED DATA
    // http://localhost:4444/blog/category/api/v1/speed/10
    //@GetMapping(value="/speed/{id}")
    categoryApiSpeedData(data) {
        return axios.get(TODO_INFO_API_PERSIST_URL+"/speed/10");
    }

    // ALL DELETE
    // http://localhost:4444/blog/category/api/v1/delete/all
    // @DeleteMapping(value="/delete/all")
    toDoApiDeleteAll() {
        return axios.delete(`${TODO_INFO_API_PERSIST_URL}/delete/all`);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/blog/category/api/v1/create
    // @PostMapping("/create")
    toDoApiCreate(categoryDto) {
        return axios.post(`${TODO_INFO_API_PERSIST_URL}/save`,categoryDto)
    }

    // LIST
    // http://localhost:4444/blog/category/api/v1/list
    //@GetMapping(value="/list")
    toDoApiList() {
       return axios.get(`${TODO_INFO_API_PERSIST_URL}/get/all`);
    }

    // FIND
    // http://localhost:4444/blog/category/api/v1/find/1
    //@GetMapping(value="/find/{id}")
    toDoApiFindById(id) {
        return axios.get(`${TODO_INFO_API_PERSIST_URL}/get/${id}`);
    }

    // UPDATE
    // http://localhost:4444/blog/category/api/v1/update/1
    //@PutMapping(value="/update/{id}")
    toDoApiUpdate(id, categoryDto) {
        return axios.put(`${TODO_INFO_API_PERSIST_URL}/update`,categoryDto);
    }

    // DELETE BY ID
    // http://localhost:4444/blog/category/api/v1/delete/1
    // @DeleteMapping(value="/delete/{id}")
    toDoApiDeleteById(id) {
        return axios.delete(`${TODO_INFO_API_PERSIST_URL}/delete/${id}`);
    }
} //end class ToDoInfoApi

// Export Default
export default new ToDoInfoApi();