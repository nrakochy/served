(ns served.app.response)

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

(def media-types 
   {
   "htm"    "text/html"
   "html"   "text/html"
   "json"   "application/json"
   "text"   "text/plain"
  }
)

(defn set-status [resp status]
)
  

(defn set-headers [] 
)

(defn set-body [])

(defn process-request [request]
  {:status 200 
   :headers {"Content-Type" "text/html"}
   :body request})

(defn respond [request]
  (process-request request)
)



