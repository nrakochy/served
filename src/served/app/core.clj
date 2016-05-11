(ns served.app.core
  "Entrypoint"
  (:require [served.app.response :refer [respond]])
  (:require [served.middleware.route :refer [compile-routes]])
)

(def routes-list 
  [{:name "form" :methods [:get :post]}
   {:name "method_options" :methods [:get :post]} 
   {:name "logs"} 
   {:name "directory-links" :root_path true}])

(def routes (compile-routes routes-list))

(defn handler 
  [request]
 "Public method for processing request"
  (respond request routes)
)
  
  
