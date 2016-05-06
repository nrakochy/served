(ns served.app.core
  "Entrypoint"
  (:require [served.app.response :refer[respond]])
)

(defn handler 
  [request]
 "Public method for processing request"
  (respond request)
)
  
