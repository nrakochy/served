(ns served.app.response)

(defn ok [request]
  {:status 200 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn not-found [request]
  {:status 404 
   :headers {"Content-Type" "text/html"}
   :body "Not found"})

(defn method-not-allowed [request]
  {:status 405 
   :headers {"Content-Type" "text/html"}
   :body "You can't make that kind of request here."})

(defn allowed-methods [route]
  (let [allowed-list (:methods route)]    
  (or allowed-list '(:get)))
)

(defn extract-matching-route [request routes-map]
  (let [requested-route (:uri request)]
  (some #(if (-> % :path (= requested-route)) %) routes-map))
)

(defn requested-method [request matching-route]
  (let [requested #{(:request-method request)}]
  (let [allowed-list (allowed-methods matching-route)]
  (some requested allowed-list)))  
)

(defn process-request [request requested-route]
  (if (requested-method request requested-route) 
    (ok request)
    (method-not-allowed request))
)

(defn respond [request routes-map]
  (let [requested-route (extract-matching-route request routes-map)]
  (if requested-route 
    (process-request request requested-route)
    (not-found request)))
)


