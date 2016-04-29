(ns served.response)

(def codes 
  {
    :ok 200
    :no-content 204
    :found 302    
    :created 303    
    :not-modified 304    
    :bad-request 400
    :forbidden 403
    :not-found 404
    :method-not-allowed 405
    :server-error 500 
  }
)

(defn add-status [resp status]
)
  

(defn set-headers [] 
)

(defn set-body [])

(defn respond [request]
  {:status (get codes :ok)  
   :headers {"Content-Type" "text/html"}
   :body request})

