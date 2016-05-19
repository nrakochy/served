(ns served.app.core
  "Entrypoint"
  (:require [served.app.request :refer [lookup-route]])
  (:require [served.app.response :refer [respond]])
  (:require [served.middleware.route :refer [compile-routes]])
)

(def routes-list 
  [{:name "form" :methods [:get :put]}
   {:name "file1"}
   {:name "text-file.txt"}
   {:name "method_options" :methods [:get :post]} 
   {:name "logs"} 
   {:name "directory-links" :root_path true}])

(defn not-found [request]
  (if (seq request) 
    request
    {:status 404 
    :headers {"Content-Type" "text/html"}
    :body "Not found"})
)

(def routes (compile-routes routes-list))

(defn process-request [mapped-request]
    (-> mapped-request 
      (respond)
    )
)

(defn handler 
  [request]
 "Public method for processing request"
  (let [mapped-request (lookup-route request routes)]
    (if (:matching-route mapped-request)
	(process-request mapped-request)
	(not-found mapped-request)))
)
  
  
