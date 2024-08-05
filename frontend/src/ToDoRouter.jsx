// rfce

// REACT
import React from "react";
import { withTranslation } from "react-i18next";
import { Navigate, Route, Routes } from "react-router-dom";
import ToDoInfoCreate from "./components/toDoInfo/ToDoInfoCreate";
import ToDoInfoList from "./components/toDoInfo/ToDoInfoList";
import ToDoInfoUpdate from "./components/toDoInfo/ToDoInfoUpdate";
import ToDoInfoView from "./components/toDoInfo/ToDoInfoView";

// HEADER,MAIN,FOOTER
import ToDoInfoFooter from "./components/ToDoFooter";
import ToDoInfoHeader from "./components/ToDoHeader";
import ToDoMain from "./components/ToDoMain";
import NotFound from "./components/NotFound";

// FUNCTION COMPONENT
function ToDoRouter() {
  return (
    // <div>ToDoRouter</div>
    // <>ToDoRouter</>
    <React.Fragment>
      {/* Blog Header */}
      <ToDoInfoHeader logo="fa-solid fa-blog"></ToDoInfoHeader>

      {/* Blog Main */}
      <div className="container App-header" style={{marginTop:"5rem"}}>
        <Routes>
          <Route path={"/"} element={<ToDoMain />} />
          <Route path={"/index"} element={<ToDoMain />} />

          {/*Blog Categories */}
          {/* http://localhost:3000/blog/category/list */}
          <Route path={"/blog/category/list"} element={<ToDoInfoList />} />
          <Route path={"/blog/category/create"} element={<ToDoInfoCreate />} />
          <Route path={"/blog/category/view/:id"} element={<ToDoInfoView />} />
          <Route path={"/blog/category/update/:id"} element={<ToDoInfoUpdate />} />

          {/* <Route path={"*"} element={<Navigate to={"/"}/>} /> */}
          <Route path={"*"} element={<NotFound/>} />

        </Routes>
        {/* <BlogMain></BlogMain> */}
      </div>

      {/* Blog Footer */}
      <ToDoInfoFooter copy="Tüm Haklar Saklıdır."></ToDoInfoFooter>
    </React.Fragment>
  ); //end return
} // end ToDoRouter

// I18N
// EXPORT Hight Order Component
// export default ToDoRouter;
export default withTranslation()(ToDoRouter);
