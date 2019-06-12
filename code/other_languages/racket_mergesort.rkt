#lang racket
(require racket/cmdline)

(define (merge-sort xs)
  (cond
    [(or (null? xs) (null? (cdr xs))) xs]
    [(null? (cddr xs))
     (merge-lists (list (car xs)) (cdr xs))]
    [#t
     (let ([x (ceiling (/ (length xs) 2))])
       (merge-lists (merge-sort (take xs x))
                    (merge-sort (drop xs x))))]))

(define (merge-lists xs ys)
  (cond
    [(null? xs) ys]
    [(null? ys) xs]
    [(< (car xs) (car ys))
     (cons (car xs) (merge-lists (cdr xs) ys))]
    [#t 
     (cons (car ys) (merge-lists xs (cdr ys)))]))