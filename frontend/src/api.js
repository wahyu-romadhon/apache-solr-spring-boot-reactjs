const API_HOST = window.location.hostname;
const API_PORT_Server_Java = "8080";
const URL_Server_Solr = `http://${API_HOST}:${API_PORT_Server_Java}`;

export const getDataSolrByName = async (name) => {
  return fetch(`${URL_Server_Solr}/api/employee/${name}`).then((response) =>
    response.json()
  );
};
