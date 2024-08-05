// rfce
import React, { useEffect, useState } from "react";
import { withTranslation } from "react-i18next";

//REDIRECT
import { Link, useNavigate } from "react-router-dom";
import ToDoInfoApi from "../../services/ToDoInfoApi";

// FUNCTION
function ToDoInfoList({ t, i18n, props }) {
  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [toDoInfoApiImplListData, setToDoInfoApiImplListData] =
    useState([]);

  // EFFECT
  useEffect(() => {
    fetchToDoInfoApiImplListData();
  }, []);

  // API CALLS (asyn-await)
  const fetchToDoInfoApiImplListData = async () => {
    try {
      const response = await ToDoInfoApi.toDoApiList();
      setToDoInfoApiImplListData(response.data);
    } catch (error) {
      console.error("Error fetching toDoInfoApiImplListData: ", error);
    }
  }; //end fetchToDoInfoApiImplListData
  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////

  // FUNCTION (promise)
  // Listeden eğer bir manipulation(değiştirirsem) liste güncel halini göstersin.
  const listManipulationAfter = () => {
    ToDoInfoApi.toDoApiList()
      .then((response) => {
        console.log(response);
        console.log(response.data);
        console.log(response.status);
        console.log(response.headers);
        if (response.status === 200) {
          setToDoInfoApiImplListData(response.data);
        }
      })
      .catch((error) => {
        error.message && console.error("Error: ", error.message);
      });
  };

  ///////////////////////
  // SPEED DATA
  // DELETE ALL DATA

  ///////////////////////
  // LOCAL STORAGE VIEW-ID
  const localStorageViewToDoInfoId = (id) => {
    // 1.YOL (id=> useParams)
    // 2.YOL (id=> localStorage)
    localStorage.setItem("view_toDoInfo_Id", id);
  };

  // LOCAL STORAGE UPDATE-ID
  const localStorageUpdateToDoInfoId = (id) => {
    // 1.YOL (id=> useParams)
    // 2.YOL (id=> localStorage)
    localStorage.setItem("update_toDoInfo_Id", id);
  };

  ///////////////////////
  // BLOG CATEGORY DELETE
  const setDeleteToDoInfo = (id) => {
    if (window.confirm(id + " nolu yapılacak görevi silmek istiyor musunuz ?")) {
      ToDoInfoApi.toDoApiDeleteById(id)
        .then((response) => {
          if (response.status === 200) {
            listManipulationAfter();
            navigate("/blog/category/list"); //1.YOL
            // window.location="/blog/category/list"; //2.YOL
          }
        })
        .catch((err) => {
          console.error("Error: ", err.message);
          window.alert("Yapılacak görev silinirken hata oluştu.");
          err.message && console.error("Error: ", err.message);
          window.location = "/blog/category/list";
          //return; // İşlem iptal edilirse return yapıyoruz.
        });
    } else {
      window.alert("Silme işlemi iptal edildi.");
      window.location = "/blog/category/list";
    }
  };

  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////
  // return
  return (
    <React.Fragment>
      <h1 className="text-center display-5 mb-5">{t("to_do_list")}</h1>
      <Link className="btn btn-primary me-2" to="/blog/category/create">
        {t("to_do_create")}
      </Link>
      <table className="table table-striped table-responsive mb-4">
        <thead>
          <tr>
            <th>{t("id")}</th>
            <th>{t("to_do_content")}</th>
            <th>{t("date")}</th>
            <th>{t("update")}</th>
            <th>{t("show")}</th>
            <th>{t("delete")}</th>
          </tr>
        </thead>

        <tbody>
          {toDoInfoApiImplListData.map((item) => (
            <tr key={item.toDoId}>
              <td>{item.toDoId}</td>
              <td>{item.content}</td>
              {/* <td>{new Date(item.createdAt).toLocaleString()}</td> */}
              <td>{item.createDate}</td>
              <td>
                <Link
                  className="btn btn-warning"
                  to={`/blog/category/update/${item.toDoId}`}
                  onClick={() =>
                    localStorageUpdateToDoInfoId(item.toDoId)
                  }
                >
                  {t("update")}
                </Link>
              </td>

              <td>
                <Link
                  className="btn btn-info"
                  to={`/blog/category/view/${item.toDoId}`}
                  onClick={() =>
                    localStorageViewToDoInfoId(item.toDoId)
                  }
                >
                  {t("show")}
                </Link>
              </td>

              <td>
                <Link
                  className="btn btn-danger"
                  onClick={() => setDeleteToDoInfo(item.toDoId)}
                >
                  {t("delete")}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
  
    </React.Fragment>
  ); //end return
} //end ToDoInfoList

// EXPORT
export default withTranslation()(ToDoInfoList);
