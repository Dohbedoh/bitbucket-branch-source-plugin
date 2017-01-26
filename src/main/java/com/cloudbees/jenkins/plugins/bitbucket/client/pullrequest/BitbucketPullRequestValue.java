/*
 * The MIT License
 *
 * Copyright (c) 2016, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cloudbees.jenkins.plugins.bitbucket.client.pullrequest;

import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketPullRequestDestination;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketPullRequest;
import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketPullRequestSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitbucketPullRequestValue implements BitbucketPullRequest {
    private BitbucketPullRequestValueDestination destination;
    private BitbucketPullRequestValueRepository source;
    private String id;
    private String title;

    private Links links;

    private Author author;

    public BitbucketPullRequestSource getSource() {
        return source;
    }

    public void setSource(BitbucketPullRequestValueRepository source) {
        this.source = source;
    }

    @Override
    public BitbucketPullRequestValueDestination getDestination() {
        return destination;
    }

    public void setDestination(BitbucketPullRequestValueDestination destination) {
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getLink() {
        return links.html.href;
    }

    @Override
    public String getAuthorLogin() {
        return author.username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLinks(Links link) {
        this.links = link;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links {
        private Html html;
        public Links() {}
        // for tests
        public Links(String link) {
            html = new Html();
            html.href = link;
        }
        public void setHtml(Html html) {
            this.html = html;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class Html {
            public String href;
            public Html() {}
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {
        private String username;
        public Author() {}
        public Author(String username) {
            this.username = username;
        }
    }

}