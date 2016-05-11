(ns served.app.response)

(defn ok [request]
  {:status 200 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn not-found [request]
  {:status 404 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn method-not-allowed [request]
  {:status 405 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn paths [routes]
  (map :path routes)   
)

(defn allowed-methods [route]
  (let [allowed-list (:methods route)]    
  (or allowed-list '(:get)))
)

(defn invalid-path? [request routes-map] 
  (not 
    (let [requested-uri (get request :uri)]
    (.contains (paths routes-map) requested-uri)))
  
)

(defn process-request [request routes-map]
  (if (invalid-path? request routes-map)
    (not-found request)
    (ok request))
)

(defn respond [request routes-map]
  (process-request request routes-map))

