// rfce

// REACT
import React from "react";
import { withTranslation } from "react-i18next";
import { Navigate, Route, Routes } from "react-router-dom";
import BlogCategoryCreate from "./components/toDoInfo/ToDoInfoCreate";
import BlogCategoryList from "./components/toDoInfo/ToDoInfoList";
import BlogCategoryUpdate from "./components/toDoInfo/ToDoInfoUpdate";
import BlogCategoryView from "./components/toDoInfo/ToDoInfoView";

// HEADER,MAIN,FOOTER
import BlogFooter from "./components/ToDoFooter";
import BlogHeader from "./components/ToDoHeader";
import ToDoMain from "./components/ToDoMain";
import NotFound from "./components/NotFound";

// FUNCTION COMPONENT
function ToDoRouter() {
  return (
    // <div>ToDoRouter</div>
    // <>ToDoRouter</>
    <React.Fragment>
      {/* Blog Header */}
      <BlogHeader logo="fa-solid fa-blog"></BlogHeader>

      {/* Blog Main */}
      <div className="container App-header" style={{marginTop:"5rem"}}>
        <Routes>
          <Route path={"/"} element={<ToDoMain />} />
          <Route path={"/index"} element={<ToDoMain />} />

          {/*Blog Categories */}
          {/* http://localhost:3000/blog/category/list */}
          <Route path={"/blog/category/list"} element={<BlogCategoryList />} />
          <Route path={"/blog/category/create"} element={<BlogCategoryCreate />} />
          <Route path={"/blog/category/view/:id"} element={<BlogCategoryView />} />
          <Route path={"/blog/category/update/:id"} element={<BlogCategoryUpdate />} />

          {/* <Route path={"*"} element={<Navigate to={"/"}/>} /> */}
          <Route path={"*"} element={<NotFound/>} />

        </Routes>
        {/* <BlogMain></BlogMain> */}
      </div>

      {/* Blog Footer */}
      <BlogFooter copy="Tüm Haklar Saklıdır."></BlogFooter>
    </React.Fragment>
  ); //end return
} // end ToDoRouter

// I18N
// EXPORT Hight Order Component
// export default ToDoRouter;
export default withTranslation()(ToDoRouter);
