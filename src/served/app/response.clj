(ns served.app.response)

(defn process-request [request]
  {:status 200 
   :headers {"Content-Type" "text/html"}
   :body (str (type request))})

(defn not-found [request]
  {:status 404 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn paths [routes]
  (map :path routes)   
)

(defn valid-path? [request routes-map] 
  (let [requested-uri (get request :uri)]
  (.contains (paths routes-map) requested-uri))
)

(defn respond [request routes-map]
  (if (valid-path? request routes-map)
    (process-request request)
    (not-found request))
)
