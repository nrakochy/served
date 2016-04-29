(ns served.response)

(defn respond [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body  request})
