(ns served.app.response)

(defn ok [request]
  {:status 200 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn method-not-allowed [request]
  {:status 405 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn allowed-methods [route]
  (let [allowed-list (:methods route)]    
  (or allowed-list '(:get)))
)

(defn requested-method [{:keys [request-method matching-route]}]
  (let [allowed-list (allowed-methods matching-route)]
  (some #{request-method} allowed-list))  
)

(defn respond [mapped-request]
  (let [original-req (dissoc mapped-request :matching-route)]
  (if (requested-method mapped-request) 
    (ok original-req)
    (method-not-allowed original-req)))
)
