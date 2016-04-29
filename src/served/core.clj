(ns served.core
  "Entrypoint"
  (require [served.response :as response])
)

(defn handler 
  [request]
 "Public method for processing request"
  response/respond [request]
)
  
  

  
