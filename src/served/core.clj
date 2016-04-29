(ns served.core
  "Entrypoint"
  (:require [served.response :refer[respond]])
)

(defn handler 
  [request]
 "Public method for processing request"
  (respond request)
)
  
  

  
